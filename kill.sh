
sudo docker rm -f $(sudo docker ps -aq --filter name=bancopdm)
sudo docker rm -f $(sudo docker ps -aq --filter name=app)

docker rmi -f $(docker image ls flavio/* -q)
