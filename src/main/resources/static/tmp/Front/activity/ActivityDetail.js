// 等待DOM加載完成
document.addEventListener("DOMContentLoaded", function () {

    const urlParams = new URLSearchParams(window.location.search);
    const activId = urlParams.get('activId');

    async function fetchActivityDetail() {
        try {
            const response = await fetch(`http://localhost:8080/u-and-me/activity/${activId}`);
            const activityDetail = await response.json();

            const dataurl = `data:image/png;base64,${activityDetail.activPic}`;

            // 要渲染的元素
            const activityNameElement = document.getElementById("activityName");
            const activityDesElement = document.getElementById("activityDes");
            const activityPicElement = document.getElementById("activityPic");

            // 將activName和activCon設置為元素的內容
            activityNameElement.textContent = activityDetail.activName;
            activityDesElement.textContent = activityDetail.activCon;
            activityPicElement.src = dataurl


        } catch (error) {
            console.error('Error fetching activity detail:', error);
        }
    }

    fetchActivityDetail();

});
