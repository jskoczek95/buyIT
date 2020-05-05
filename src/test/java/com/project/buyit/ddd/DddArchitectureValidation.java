package com.project.buyit.ddd;

import com.project.buyit.BuyitApplication;
import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeJars;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(importOptions = DoNotIncludeJars.class, packagesOf = BuyitApplication.class)
public class DddArchitectureValidation {

    private static final String DOMAIN_PACKAGE = "..domain..";
    private static final String INFRASTRUCTURE_PACKAGE = "..infrastructure..";
    @ArchTest
    public static final ArchRule HEXAGONAL_ARCHITECTURE_VALIDATION = onionArchitecture()
            .domainModels(DOMAIN_PACKAGE)
            .domainServices(DOMAIN_PACKAGE)
            .applicationServices(INFRASTRUCTURE_PACKAGE)
            .adapter("adapter", INFRASTRUCTURE_PACKAGE);
    private static final String INFRASTRUCTURE_ENTRYPOINTS_PACKAGE = "..infrastructure..entrypoint";
    @ArchTest
    public static final ArchRule ENTRYPOINTS_SHOULD_EXIST_IN_INFRASTRUCTURE = classes()
            .that().areAnnotatedWith(RestController.class)
            .should().resideInAPackage(INFRASTRUCTURE_ENTRYPOINTS_PACKAGE);
    private static final String SPRING_FRAMEWORK = "org.springframework..";
    @ArchTest
    public static final ArchRule DOMAIN_SHOULD_NOT_DEPEND_ON_FRAMEWORKS = noClasses()
            .that().resideInAPackage(DOMAIN_PACKAGE)
            .should().dependOnClassesThat().resideInAnyPackage(SPRING_FRAMEWORK)
            .because("domain should not depend on frameworks!");
    private static final String CONFIGURATION_PACKAGE = "..infrastructure..config";
    private static final String SECURITY_PACKAGE = "..infrastructure..config..security..";
    @ArchTest
    public static final ArchRule CONFIGURATIONS_SHOULD_RESIDE_IN_INFRASTRUCTURE = classes()
            .that().areAnnotatedWith(Configuration.class)
            .should().resideInAnyPackage(CONFIGURATION_PACKAGE, SECURITY_PACKAGE);
    private static final String ENTRYPOINT_COMMAND_SUFFIX = "CommandController";
    @ArchTest
    public static final ArchRule COMMAND_ENTRYPOINTS_SHOULD_USE_UNSAFE_HTTP_METHODS = noClasses()
            .that().haveSimpleNameEndingWith(ENTRYPOINT_COMMAND_SUFFIX)
            .should().beAnnotatedWith(GetMapping.class);
}
