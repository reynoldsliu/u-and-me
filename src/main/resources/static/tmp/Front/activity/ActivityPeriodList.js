document.addEventListener("DOMContentLoaded", function () {
    fetchRandomPeriods();
});

async function fetchRandomPeriods() {
    try {
        const response = await fetch('http://localhost:8080/u-and-me/activityavailable');
        const randomPeriods = await response.json();

        const cardContainers = document.querySelectorAll('.card.profile-card-5');

        randomPeriods.forEach((item, index) => {
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
                const newPageUrl = `ActivityPeriodDetail.html?activId=${item.activId}`;
                window.location.href = newPageUrl;
            });

        });
    } catch (error) {
        console.error('Error fetching random periods:', error);
    }
}