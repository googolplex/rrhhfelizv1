#!/bin/bash

# hecho para arch-en limones
# el 2017/10
cp -r /home/xoldfusion/Descargas/openxava-5.7.1_rrhhfeliz/workspace/rrhhfelizv1 rrhhfelizv1

cp *.sh rrhhfelizv1/gitfeliz
rm *.*~
rm rrhhfelizv1/*.*~
cd rrhhfelizv1
git add -A
git commit -a -m "inicio del proyecto"
git push -u origin master
