# Palindrome-Checker-App
https://github.com/Ajay20062/Palindrome-Checker-App.git

git config user.name

git config user.email

git config --global user.name "Ajay20062"

git config --global user.email "70842623+Ajay20062@users.noreply.github.com"


git init
git branch -M main
git remote add origin https://github.com/Ajay20062/Palindrome-Checker-App.git
git remote -v
git add .
git commit -m "Base application setup"
git push origin main

git checkout develop
git checkout -b feature/UC2


💾 COMMIT
git add .
git commit -m "UC2:Hardcoded palindrome "
git push origin feature/UC2

🔀 MERGE TO DEVELOP
git checkout develop
git pull
git merge feature/UC2
git push
