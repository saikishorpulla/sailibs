def call(ip,user,credid){
 sshagent([credid]) {
 // copy war
 sh "scp -o StrictHostKeyChecking=no target/app.war ${user}@${ip}:/opt/tomcat9/webapps"
 // stop tomcat
 sh "ssh ${user}@${ip} /opt/tomcat9/bin/shutdown.sh"
 // start tomcat
 sh "ssh ${user}@${ip} /opt/tomcat9/bin/startup.sh"
   }
}
