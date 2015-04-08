grails.project.work.dir = 'target'
grails.project.docs.output.dir = 'docs/manual' // for the gh-pages branch

grails.project.dependency.resolver = "maven"
grails.project.dependency.resolution = {

	inherits 'global'
	log 'warn'

	repositories {
		grailsCentral()
		mavenLocal()
		mavenCentral()

		mavenRepo 'http://repo.spring.io/milestone' // TODO remove
	}

	dependencies {
		String springSecurityVersion = '3.2.6.RELEASE'

		compile "org.springframework.security:spring-security-ldap:$springSecurityVersion", {
			excludes 'apacheds-core', 'apacheds-core-entry', 'apacheds-protocol-ldap', 'apacheds-protocol-shared',
			         'apacheds-server-jndi', 'commons-logging', 'fest-assert', 'jcl-over-slf4j', 'junit', 'ldapsdk',
			         'logback-classic', 'mockito-core', 'shared-ldap', 'slf4j-api', 'spring-beans', 'spring-context',
			         'spring-core', 'spring-ldap-core', 'spring-security-core', 'spring-test', 'spring-tx'
		}
		runtime('org.springframework.ldap:spring-ldap-core:2.0.2.RELEASE') {
			excludes 'commons-lang', 'commons-logging', 'easymock', 'gsbase', 'junit', 'spring-beans', 'spring-core', 'spring-tx'
		}
	}

	plugins {
		compile ':spring-security-core:2.0.1-SNAPSHOT'

		compile(":hibernate4:4.3.8.1") {
			export = false
		}

		build (":release:3.1.1", ":rest-client-builder:2.1.1") {
			export = false
		}
	}
}
