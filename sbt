java -Xmx512M -XX:MaxPermSize=256M -XX:+CMSClassUnloadingEnabled -jar `dirname $0`/sbt-launcher.jar "$@"
