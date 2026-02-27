# Palindrome-Checker-App
https://github.com/Ajay20062/Palindrome-Checker-App.git

git config user.name
git config user.email

git config --global user.name "Ajay20062"
git config --global user.email "ajaydharrsan@gmail.com"

git init
git branch -M main
git remote add origin https://github.com/Ajay20062/Palindrome-Checker-App.git
git remote -v
git add .
git commit -m "Base application setup"
git push origin main

Note: Ensure that main branch is pushed to remote GitHub repository

Now:
git checkout -b develop
git push -u origin develop

git branch

git checkout -b feature/UC1
git add .
git commit -m "UC1: Add welcome message module"
git push origin feature/UC1
