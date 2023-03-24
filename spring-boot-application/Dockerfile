FROM adoptopenjdk/openjdk11:ubuntu-slim
LABEL maintainer="Code Black"
RUN apt-get clean all \
	&& rm -rf /var/lib/apt/lists/* \
	&& apt-get -y update \
	&& apt-get -y upgrade \
	&& apt-get install --fix-missing --upgrade -y bash
RUN mkdir -p /usr/app/
ENV PROJECT_HOME /usr/app/
COPY target/hackathon-0.0.1-SNAPSHOT.jar $PROJECT_HOME/hackathon-0.0.1-SNAPSHOT.jar
WORKDIR $PROJECT_HOME
CMD ["java", "-jar", "./hackathon-0.0.1-SNAPSHOT.jar"]