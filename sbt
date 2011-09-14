java -Xmx1024 -Xss2M -XX:+CMSClassUnloadingEnabled -jar `dirname $0`/sbt-launcher.jar "$@"
