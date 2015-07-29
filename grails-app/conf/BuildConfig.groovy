grails.project.work.dir = 'target'
grails.project.docs.output.dir = 'docs/manual' // for the gh-pages branch

grails.project.dependency.resolver = 'maven'
grails.project.dependency.resolution = {

	inherits 'global'
	log 'warn'

	repositories {
		mavenLocal()
		grailsCentral()
		mavenCentral()
	}

	dependencies {
		String springSecurityVersion = '3.2.7.RELEASE'

		compile "org.springframework.security:spring-security-ldap:$springSecurityVersion", {
			excludes 'apacheds-core', 'apacheds-core-entry', 'apacheds-protocol-ldap', 'apacheds-protocol-shared',
			         'apacheds-server-jndi', 'commons-logging', 'fest-assert', 'jcl-over-slf4j', 'junit', 'ldapsdk',
			         'logback-classic', 'mockito-core', 'shared-ldap', 'slf4j-api', 'spring-beans', 'spring-context',
			         'spring-core', 'spring-ldap-core', 'spring-security-core', 'spring-test', 'spring-tx'
		}
		runtime('org.springframework.ldap:spring-ldap-core:2.0.3.RELEASE') {
			excludes 'commons-lang', 'commons-logging', 'easymock', 'gsbase', 'junit', 'spring-beans', 'spring-core', 'spring-tx'
		}
	}

	plugins {
		compile ':spring-security-core:2.0-RC5'

		compile(":hibernate:3.6.10.17") {
			export = false
		}

		build ':release:3.0.1', ':rest-client-builder:2.0.3', {
			export = false
		}
	}
}
