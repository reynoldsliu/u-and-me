<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html charset="UTF-8">
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
        }

        img {
            max-width: 100%;
        }

        html {
            /*:root === html*/
            font-size: 62.5%;
            /*10px*/
            --header-height: 60px;
            /*宣告變數*/
            --aside-width: 240px;
        }

        header,
        aside,
        main {
            font-size: 2.4rem;
        }

        button.btn_hamburger {
            display: none;
        }

        @media (max-width:767.98px) {
            button.btn_hamburger {
                display: inline;
            }
        }


        /*=========================== header ===========================*/
        header.header {
            /* border: 1px solid blue; */
            background-color: lightgray;
            height: var(--header-height);
            display: block;
            position: sticky;
            top: 0;

        }



        /*=========================== aside ===========================*/
        aside.aside {
            border: 1px solid green;
            background-color: lightgreen;
            width: var(--aside-width);
            height: calc(100% - var(--header-height));
            position: fixed;
            left: 0;
            top: var(--header-height);
            display: inline-block;
            overflow-y: auto;
            padding: 20px 0;

        }

        @media (max-width:767.98px) {
            aside.aside {
                top: 0;
                height: 100%;
                transform: translateX(-100%);
                transition: all 1s;
            }

            aside.aside.-on {
                transform: translateX(0%);
                /* transition: all 1s; */
            }

        }

        aside.aside nav.nav {
            /* border: 1px solid blue; */

        }

        aside.aside nav.nav ul.nav_list {
            /* border: 1px solid purple; */
            list-style: none;
            padding: 0;
            margin: 0;
        }

        aside.aside nav.nav ul.nav_list>li {
            /* border: 1px solid green; */

        }

        aside.aside nav.nav ul.nav_list>li a {
            border: 1px solid white;
            text-decoration: none;
            display: block;
            text-align: center;
            padding: 2px 0;
        }

        /*=========================== main ===========================*/
        main.main {
            border: 1px solid red;
            background-color: pink;
            min-height: calc(100vh - var(--header-height));
            width: calc(100% - var(--aside-width));
            position: relative;
            margin-left: var(--aside-width);
            display: inline-block;
            padding: 20px;
        }

        @media (max-width:767.98px) {
            main.main {
                margin-left: 0;
                width: 100%;
            }
        }

        main.main ul.item_list {
            border: 1px solid red;
            list-style: none;
            margin: 0;
            padding: 0;

            display: flex;
            flex-wrap: wrap;
        }

        main.main ul.item_list>li {
            border: 1px solid blue;
            width: calc((100% - 60px) / 4);
            margin-right: 20px;
            margin-bottom: 20px;
        }

        main.main ul.item_list>li:nth-child(4n) {
            margin-right: 0;
        }

        @media (max-width:767.98px) {
            main.main ul.item_list>li {
                /* border: 1px solid blue; */
                width: calc((100% - 20px) / 2);
            }

            main.main ul.item_list>li:nth-child(2n) {
                margin-right: 0;
            }
        }

        main.main ul.item_list>li a {
            border: 1px solid white;
            display: block;
            text-decoration: none;
        }

        main.main ul.item_list>li a div.img_block {
            border: 1px solid black;
            font-size: 0;
        }

        main.main ul.item_list>li a span.item_text {
            border: 1px solid green;
            display: block;
            white-space: nowrap;
            overflow-x: hidden;
            text-overflow: ellipsis;
        }
    </style>
</head>

<body>
    <header class="header">
        這是HEADER
        <button type="button" class="btn_hamburger">按鈕</button>
    </header>
    <aside class="aside">
        <button type="button" class="btn_hamburger">按鈕</button>
        <nav class="nav">
            <ul class="nav_list">
                <li><a href="#">連結一</a></li>
                <li><a href="#">連結二</a></li>
                <li><a href="#">連結三</a></li>
                <li><a href="#">連結四</a></li>
                <li><a href="#">連結五</a></li>
                <li><a href="#">連結一</a></li>
                <li><a href="#">連結二</a></li>
                <li><a href="#">連結三</a></li>
                <li><a href="#">連結四</a></li>
                <li><a href="#">連結五</a></li>
                <li><a href="#">連結一</a></li>
                <li><a href="#">連結二</a></li>
                <li><a href="#">連結三</a></li>
                <li><a href="#">連結四</a></li>
                <li><a href="#">連結五</a></li>
                <li><a href="#">連結一</a></li>
                <li><a href="#">連結二</a></li>
                <li><a href="#">連結三</a></li>
                <li><a href="#">連結四</a></li>
                <li><a href="#">連結五</a></li>
                <li><a href="#">連結一</a></li>
                <li><a href="#">連結二</a></li>
                <li><a href="#">連結三</a></li>
                <li><a href="#">連結四</a></li>
                <li><a href="#">連結五</a></li>
                <li><a href="#">連結一</a></li>
                <li><a href="#">連結二</a></li>
                <li><a href="#">連結三</a></li>
                <li><a href="#">連結四</a></li>
                <li><a href="#">連結五</a></li>
                <li><a href="#">最後一個連結</a></li>

            </ul>
        </nav>
    </aside>
    <main class="main">
        <ul class="item_list">
            <li>
                <a href="#">
                    <div class="img_block">
                        <img src="https://via.placeholder.com/400x300" alt="">
                    </div>
                    <span class="item_text">1這是影片標題這是影片標題這是影片標題</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <div class="img_block">
                        <img src="https://via.placeholder.com/400x300" alt="">
                    </div>
                    <span class="item_text">2這是影片標題這是影片標題這是影片標題</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <div class="img_block">
                        <img src="https://via.placeholder.com/400x300" alt="">
                    </div>
                    <span class="item_text">3這是影片標題這是影片標題這是影片標題</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <div class="img_block">
                        <img src="https://via.placeholder.com/400x300" alt="">
                    </div>
                    <span class="item_text">4這是影片標題這是影片標題這是影片標題</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <div class="img_block">
                        <img src="https://via.placeholder.com/400x300" alt="">
                    </div>
                    <span class="item_text">5這是影片標題這是影片標題這是影片標題</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <div class="img_block">
                        <img src="https://via.placeholder.com/400x300" alt="">
                    </div>
                    <span class="item_text">6這是影片標題這是影片標題這是影片標題</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <div class="img_block">
                        <img src="https://via.placeholder.com/400x300" alt="">
                    </div>
                    <span class="item_text">7這是影片標題這是影片標題這是影片標題</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <div class="img_block">
                        <img src="https://via.placeholder.com/400x300" alt="">
                    </div>
                    <span class="item_text">8這是影片標題這是影片標題這是影片標題</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <div class="img_block">
                        <img src="https://via.placeholder.com/400x300" alt="">
                    </div>
                    <span class="item_text">9這是影片標題這是影片標題這是影片標題</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <div class="img_block">
                        <img src="https://via.placeholder.com/400x300" alt="">
                    </div>
                    <span class="item_text">10這是影片標題這是影片標題這是影片標題</span>
                </a>
            </li>
        </ul>
    </main>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        $("button.btn_hamburger").on("click", function(){
            $("aside.aside").toggleClass("-on");
        });

    </script>
</body>

</html>