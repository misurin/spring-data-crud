#!/bin/sh

APP_BASE=/home/dpi/DpiAgentNov
APP_NAME="DPI Agent"
APP_JAR=DpiAgent-1.0-Nov.jar
APP_OPTS="-XX:-LoopUnswitching -XX:+UseConcMarkSweepGC -XX:+CMSClassUnloadingEnabled"

export LD_LIBRARY_PATH=${APP_BASE}
PID=$(pgrep -f ${APP_JAR})

cd ${APP_BASE} #This is to avoid using java -classpath

stop_app(){
    echo "Stopping $APP_NAME..."
    kill ${PID}
    i=0
    while pgrep -f ${APP_JAR} && [[ ${i} -lt 10 ]]
    do
        sleep 1
        i=$((i+1))
        echo "${APP_NAME} is still running..."
    done
    if pgrep -f ${APP_JAR}; then
        echo "Failed to stop ${APP_NAME}"
    else
        echo "$APP_NAME stopped successfully!"
    fi
}

start_app(){
    echo "Starting $APP_NAME from ${APP_BASE}/${APP_JAR}..."
    nohup java ${APP_OPTS} -jar ${APP_BASE}/${APP_JAR} > /dev/null 2>&1 &
    echo "$APP_NAME has successfully started with PID $!"
}

case $1 in
    start)
        if [[ -z ${PID} ]]; then
            start_app
        else
            echo "$APP_NAME is already running with PID ${PID}..."
        fi
    ;;

    stop)
        if [[ -n ${PID} ]]; then
            stop_app
        else
            echo "$APP_NAME is not running ..."
        fi
    ;;

    restart)
        #kill the app first
        echo "=========================================="
        if [[ -n ${PID} ]]; then
            stop_app
        else
            echo "$APP_NAME is not running ..."
        fi
        #then start the app
        echo "=========================================="
        start_app
    ;;

    status)
         if [[ -n ${PID} ]]; then
            echo "$APP_NAME is running with PID ${PID}"
        else
            echo "$APP_NAME is not running ..."
        fi
    ;;
    *)
        echo "Choose an option start/stop/restart/status for the app"
    ;;
esac

