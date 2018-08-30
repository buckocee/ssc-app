#!/bin/bash

while read p; do
  # echo $p
  mkdir ~/Downloads/brokers/$p
  cd ~/Downloads/brokers/$p
  for i in {1..20}; do
    wget -O $p-$i.html https://freefreightsearch.com/brokers/directory/$p?page=$i
    sleep 2
    echo "Created $p-$i.html"
  done
done <$1
