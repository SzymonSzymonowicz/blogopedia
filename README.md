# Blogopedia (TJE lab project) Spring MVC

---

### Blog with postwall, each post can be either private or public. Public posts can be edited by anyone and after that the editor becomes co-author. He additionally gains rights to delete the post and manage all of its comments. After logging in all of user's posts are shown. Clicking homepage button guides to page with all of user's and all of public posts. Files can be attached to a post. The project fullfills most of given requirements.



#### Technologies:
* Spring Boot
* Spring Data JPA
* Spring Web
* Spring Security (Basic auth)
* Thymeleaf
* Lombok

#### Database:
* ~~H2 (in-memory)~~
* MySql

#### Deploy:
* [Heroku](https://blogopedia.herokuapp.com/) (currently having some issues with remote database thus initial posts are not loaded)

> Admin credentials: `admin` `admin` <br> Every user initialized by database credentials: `<username>` `password`

# Screenshots

---

## Homepage not logged in (anonymous)
![fEXVO7.png](https://iili.io/fEXVO7.png)

## Registration
![fEXmbt.png](https://iili.io/fEXmbt.png)

## Login form (provided by spring security)
![fEXWb9.png](https://iili.io/fEXWb9.png)

## Page after logging in
### There are shown all of user's posts
![fEXaiG.png](https://iili.io/fEXaiG.png)

## On Homepage button
### Shows all of user's posts and all public posts
![fEXjWu.png](https://iili.io/fEXjWu.png)

## New post form with validation
![fEXhxe.png](https://iili.io/fEXhxe.png)

## New comment form with validation
![fEXlff.png](https://iili.io/fEXlff.png)



## Own private post options
![fEXe0x.png](https://iili.io/fEXe0x.png)

## Managing own post's comments
![fEX0l4.png](https://iili.io/fEX0l4.png)

## Options for own comment under someone's post
![fEXOfj.png](https://iili.io/fEXOfj.png)

## Edit comment view
![fEX1Ul.png](https://iili.io/fEX1Ul.png)



## Public post options
### While not being co-author
![fEXkUQ.png](https://iili.io/fEXkUQ.png)

## Editing public post with validation
![fEXMRS.png](https://iili.io/fEXMRS.png)

## Post options after becoming co-author
![fEXwib.png](https://iili.io/fEXwib.png)

## Comment managment options after becoming co-author
![fEXRDX.png](https://iili.io/fEXRDX.png)



## Attach files to a post
![fEXPsa.png](https://iili.io/fEXPsa.png)

## Ordered posts
![fEXUOP.png](https://iili.io/fEXUOP.png)

## Searching panel per given username
![fEX8JV.png](https://iili.io/fEX8JV.png)

## Searching panel for posts by selected option
![fEXS5B.png](https://iili.io/fEXS5B.png)

## Found posts view
### Similar would be displayed if other options choosen
![fEXgb1.png](https://iili.io/fEXgb1.png)



## Logged Admin
![fEXYVs.png](https://iili.io/fEXYVs.png)

## Admin has all rights and options to manage all posts both private and public
![fEX7xn.png](https://iili.io/fEX7xn.png)

## User Statistics panel seen only by admin
![fEX4zF.png](https://iili.io/fEX4zF.png)

## Statistics view
![fEX6Wg.png](https://iili.io/fEX6Wg.png)
