include ..\..\MakeVars

DELAY = ..\..\Utils\delay.exe
PRCURRENTTIME = ..\..\Utils\currenttime.exe

build:
        cd TestServer
	$(MAKE) build
        cd ..
	cd TestBeans
	$(MAKE) build
	cd ..\TestClientForJava1.4
	$(MAKE) build
	cd ..

start-server:
        @cd TestServer
        @$(MAKE) /C start-server
        @cd ..
        @cd TestBeans
        @$(MAKE) /C start-server
        @cd ..

stop-server:
        @cd TestServer
        @$(MAKE) /C stop-server
        @cd ..
        @cd TestBeans
        @$(MAKE) /C stop-server
        @cd ..

start-client:
        @cd TestClientForJava1.4
        @$(MAKE) /C /I start-client
        @cd ..

test:
        @echo Jboss4 integration test starting at:
        @$(PRCURRENTTIME)
        @$(MAKE) /C start-server
        @$(DELAY) 200
        @$(MAKE) /C start-client
        @$(MAKE) /C stop-server

clean:
	cd TestBeans
	$(MAKE) clean
	cd ..\TestClientForJava1.4
	$(MAKE) clean
	cd ..
