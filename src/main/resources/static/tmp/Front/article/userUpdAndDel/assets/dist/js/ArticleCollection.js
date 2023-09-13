let baseURL = window.location.protocol + "//" + window.location.host + "/u-and-me/";
const statusMapping = new Map([
    [1, '商城版'],
    [2, '行程版'],
    [3, '揪團版'],
]);
// <!--網頁載入後執行-->
document.addEventListener("DOMContentLoaded", function () {
    fetchMemIdArticleList();
    fetchCollectedOrNot();
});
const collection_el = document.getElementById('collection');


// document.querySelector('#btnSubmit').addEventListener('click', () => {
async function fetchMemIdArticleList() {
    try {
        const response = await fetch(`${baseURL}getArticleFromCollectionByMemId`);
        const resMemIdArticleList = await response.json();
        console.log(resMemIdArticleList);
        const articles_el = document.getElementById("articles");
        // 1. 取得要被動態插入內容的元素
        articles_el.innerHTML = "";
        // 2. 先清空容器，以便插入新的文章內容

        resMemIdArticleList.forEach(MemIdArticle => {
            const articleDiv = document.createElement("div"); // 在每次迭代中創建新的 div 元素
            articleDiv.className = "articlecardframe"; // 添加 class
            articleDiv.innerHTML = `
            <a  href="${baseURL}tmp/Front/article/articleIndex/articleDetail.html?articleId=${MemIdArticle.articleId}"  
            style="text-decoration: none;" onload="fetchCollectedOrNot(this)">
<div class="articlecard">
<div style="display: flex;vertical-align: top; margin-right: 10px;">
    <div>
        <p style="color: grey;margin-bottom: 8px;width:50px;">${statusMapping.get(MemIdArticle.memId)}</p>
    </div>

</div>
<div>
    <div>
        <h5>${MemIdArticle.articleTitle}</h5>
    </div>

    <div>
        <p class="JQellipsis">
            ${MemIdArticle.articleContent}
        </p>
        <span style="position: relative; z-index: 3;">
            <img src="assets/brand/like.jpg" style="width: 20px;">
        </span>
        <span style="margin-left: 5px; margin-right: 20px;">
            ${MemIdArticle.articleLike}
        </span>
        <span style="position: relative; z-index: 3;">
            <img src="assets/brand/comment.jpg" style="width: 25px;">
        </span>
        <span style="margin-left: 5px; margin-right: 20px;">
            ${MemIdArticle.commentNum}
        </span>

    </div>
</div>
</a>
`;

            articles_el.appendChild(articleDiv); // 將文章 div 添加到容器中


            // 超過130個字以"..."取代
            $(function () {
                var len = 130;
                $(".JQellipsis").each(function (i) {
                    if ($(this).text().length > len) {
                        $(this).attr("title", $(this).text());
                        var text = $(this).text().substring(0, len - 1) + "...";
                        $(this).text(text);
                    }
                });
            });

        });

    } catch (error) {
        console.error("Error fetching article list:", error);
    }
}


// 使用 fetch API 請求article_collection資料，讀取是否已收藏過
// async function fetchCollectedOrNot(articleId) {
//     let articleId = articleId.value;
//     try {
//         const postData = {

//             // memId先寫死，等到串filter再帶session
//             collectionId: {
//                 memId: 1,
//                 articleId: articleId
//             }
//         }
//         console.log(postData);
//         // 使用反引号（‵‵)可以插入变量${}。若使用單引號 ('')則只能使用字符串连接，例:'Hello, ' + name + '!';
//         const url = `${baseURL}CollectionExsitOrNot`;

//         fetch(url, {
//             method: "POST",
//             headers: {
//                 "Content-Type": "application/json"
//             },
//             body: JSON.stringify(postData)
//         })
//             .then(response => response.json())
//             .then(data => {
//                 // 成功接收并解析响应后的处理逻辑
//                 console.log(data);


//                 // 根据 data 值来更新按钮的 HTML 内容
//                 if (data === 1) {
//                     // 如果 data 为 1，显示已收藏的图标
//                     console.log("已收藏");

//                     collection_el.innerHTML = `
// <svg xmlns="http://www.w3.org/2000/svg" width="25px" height="30" fill="#6c757d" class="bi bi-bookmark-fill"
//     viewBox="0 0 16 16">
//     <path
//         d="M2 2v13.5a.5.5 0 0 0 .74.439L8 13.069l5.26 2.87A.5.5 0 0 0 14 15.5V2a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2z" />
// </svg>
// `;
//                 } else if (data === 0) {
//                     // 如果 data 为 0，显示未收藏的图标
//                     console.log("未收藏");
//                     collection_el.innerHTML = `
// <svg xmlns="http://www.w3.org/2000/svg" width="25px" height="30" fill="currentColor" class="bi bi-bookmark"
//     viewBox="0 0 16 16">
//     <path
//         d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z" />
// </svg>
// `;
//                 }
//             })
//             .catch(error => {
//                 // 处理错误
//                 console.error('Error:', error);
//             });
//     } catch (error) {
//         console.error("Error fetching collection", error);
//     }
// }

// // 使用 fetch API ，新增新增或刪除收藏
// collection_el.addEventListener("click", () => {

//     const postData = {

//         // memId先寫死，等到串filter再帶session
//         collectionId: {
//             memId: 1,
//             articleId: articleId
//         }
//     };
//     console.log(postData);
//     const url = `${baseURL}AddOrRemoveCollection`;
//     fetch(url, {
//         method: "POST",
//         headers: {
//             "Content-Type": "application/json"
//         },
//         body: JSON.stringify(postData)
//     })
//         .then(response => response.json())
//         .then(data => {
//             // 后端返回的数据
//             // console.log(response);
//             // console.log(data);
//             if (data === 1) {
//                 console.log("已加入收藏");
//                 // 如果 data 为 1，显示已收藏的图标
//                 collection_el.innerHTML = `
// <svg xmlns="http://www.w3.org/2000/svg" width="25px" height="30" fill="#6c757d" class="bi bi-bookmark-fill"
//     viewBox="0 0 16 16">
//     <path
//         d="M2 2v13.5a.5.5 0 0 0 .74.439L8 13.069l5.26 2.87A.5.5 0 0 0 14 15.5V2a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2z" />
// </svg>
// `;
//                 swal.fire({
//                     title: '已加入收藏',
//                     icon: 'success',
//                     showCancelButton: false,
//                     confirmButtonText: '確定'
//                     // cancelButtonText: '取消'
//                 })
//             } else if (data === 0) {
//                 // 如果 data 为 0，显示未收藏的图标
//                 console.log("已刪除收藏");
//                 collection_el.innerHTML = `
// <svg xmlns="http://www.w3.org/2000/svg" width="25px" width="30" fill="currentColor" class="bi bi-bookmark"
//     viewBox="0 0 16 16">
//     <path
//         d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z" />
// </svg>
// `;
//             }
//         })
//         .catch(error => {
//             console.log(error);
//             console.error('Error:', error);
//         });


// })
