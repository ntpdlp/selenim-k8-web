1)To start HUB: java -jar selenium-server-4.5.0.jar hub

2)To start NODEs:
This nodes will be registered: Chrome(2), Gecko-FF(2) , Safari (1) default on MAC
java -jar -Dwebdriver.<type>.<name>s path/to/selenium/server.jar node --config /path/to/nodeConfig.json
java -jar -Dwebdriver.gecko.driver=geckodriver -Dwebdriver.chrome.driver=chromedriver selenium-server-4.5.0.jar node --config hub_node_config.json
