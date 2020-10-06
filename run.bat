@echo off
echo start generate archetype project
cd archetype && mvn archetype:create-from-project && echo start install archetype .... && cd target/generated-sources/archetype && mvn install && echo archetype installed && exit
