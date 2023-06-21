FROM openjdk:8  
COPY . /var/www/java  
WORKDIR /var/www/java  
RUN javac a.java  
CMD ["java", "Hello"]  
