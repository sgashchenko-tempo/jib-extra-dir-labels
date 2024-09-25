.PHONY: jib-build-tar
jib-build-tar:
	./gradlew clean jibBuildTar

.PHONY: jib-docker-build
jib-docker-build:
	./gradlew clean jibDockerBuild
