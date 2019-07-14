FROM alpine/git
WORKDIR /app
ARG SSH_PRIVATE_KEY
 
RUN echo "${SSH_PRIVATE_KEY}" > id_rsa

RUN touch known_hosts
RUN ssh-keyscan gitlab.alm.gsnetcloud.corp >> known_hosts


#RUN git config --global http.proxy 172.31.219.30:8080
RUN git clone --single-branch --branch develop https://n130065:2Rburnut!4@gitlab.alm.gsnetcloud.corp/GlobalTechArchitecture/resilience4jSpringApplicationMock.git -c http.sslverify=false
RUN ls  -l 
CMD echo "*************************************************************************************************************"
RUN pwd
RUN ls  -l /app/resilience4jSpringApplicationMock
FROM maven:3.5-jdk-8-alpine
WORKDIR /app
COPY --from=0 /app/resilience4jSpringApplicationMock /app 
RUN cat pom.xml
CMD echo "*************************************************************************************************************"
RUN ls  -l /app
RUN mvn install -X -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.ssl.ignore.validity.dates=true