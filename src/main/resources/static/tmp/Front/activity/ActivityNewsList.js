document.addEventListener("DOMContentLoaded", function () {
    fetchRandomNews();
});

async function fetchRandomNews() {
    try {
        const response = await fetch('http://localhost:8080/u-and-me/activityall');
        const randomNews = await response.json();

        const cardContainers = document.querySelectorAll('.card');

        randomNews.forEach((item, index) => {

            const cardContainer = cardContainers[index];
            const cardImg = cardContainer.querySelector('.card-img-top');
            const cardTitle = cardContainer.querySelector('.card-title');
            const cardText = cardContainer.querySelector('.card-text');
            const detailBtn_el = cardContainer.querySelector('.btn-container');

            const dataurl = `data:image/png;base64,${item.activPic}`;

            cardImg.src = dataurl;
            cardTitle.textContent = item.activName;
            cardText.textContent = item.activCon;

            detailBtn_el.addEventListener('click', function () {
                const newPageUrl = `ActivityDetail.html?activId=${item.activId}`;
                window.location.href = newPageUrl;
            });


        });
    } catch (error) {
        console.error('Error fetching random news:', error);
    }
}
