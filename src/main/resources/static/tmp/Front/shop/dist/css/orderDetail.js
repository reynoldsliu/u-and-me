  $(document).ready(function () {
    $("#loadAttraction").click(function () {

        var id = $("#attractionId").val();
        console.log( id);
        var baseUrl = window.location.protocol + "//" + window.location.host;

        fetch( baseUrl+ "/u-and-me/getAttraction/" + id)
            .then(response => {
                if (!response.ok) {
                    throw new Error("Attraction not found!!!");
                }
                return response.json();
            })
            .then(attr => {
                const attr_el = document.getElementById("attrTarget");
                //document.getElementById("id").textContent = data.attrId;
                const row = document.createElement("tr");
                row.innerHTML = `
                        <td style="width: 100px;text-align: center;vertical-align: middle;">${attr.attrName}</td>
                        <td style="width: 130px;text-align: center;vertical-align: middle;">${attr.attrAddr}</td>
                        <td style="width: 65px;text-align: center;vertical-align: middle;">${attr.attrIlla}</td>
                        <td style="width: 65px;text-align: center;vertical-align: middle;">${attr.attrTypeId}</td>
                        <td style="width: 65px;text-align: center;vertical-align: middle;">${attr.attrCostRange}</td>
                        <td style="width: 65px;text-align: center;vertical-align: middle;">${attr.attrBussTime}</td>
                        <td>
                         <button class="btn btn-outline-success" onclick="redirectToDetailPage(${attr.attrId})">
                          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"fill="currentColor" class="bi bi-pen" viewBox="0 0 16 16">
                          <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/>
                          </svg>
                          </button>
                        </td>
                    `;
                    attr_el.insertAdjacentElement('beforeend',row);
                // You can continue to populate other attributes here
            })
            .catch(error => {
                alert(error.message);
            });


        //   $.ajax寫法
        // < !--$.ajax({-- >
        // < !--url: baseUrl + "getAttraction/" + id, -->
        // < !--method: "GET", -->
        // < !--dataType: "json", -->
        // < !--success: function (data) {
        //             -->
        // < !--$("#id").text(JSON.stringify(data)); -->
        // < !--                    // You can continue to populate other attributes here-->
        // < !--                }, -->
        // < !--error: function () {
        //             -->
        // < !--alert("Attraction not found"); -->
        // < !--                }-- >

    });
    });



    var findAllAttraction = async function() {
        var baseUrl = window.location.protocol + "//" + window.location.host + window.location.pathname;
        try {
            const response = await fetch('getAllAttr');
            console.log(response);
            const attrList = await response.json();
                            console.log(attrList);
            const listStart_el = document.querySelector("#attrTarget");
            let countNum = 0;
            attrList.forEach(attr => {
                const row = document.createElement("tr");
                // attr_id, attr_veri_sta, attr_sta, attr_name, attr_addr,
                // attr_lon, attr_lat, attr_illa, attr_type_id, attr_buss_time, attr_cost_range, attr_rep
                // 1	1	1	Attraction 1	123 Main St	12.345	67.89
                // Description for Attraction 1	1	9:00 AM - 5:00 PM	2	Representative for Attraction 1
                row.innerHTML = `
                        <td style="text-align: center;vertical-align: middle;">${++countNum}</td>
                        <td style="width: 100px;text-align: center;vertical-align: middle;">${attr.attrName}</td>
                        <td style="width: 130px;text-align: center;vertical-align: middle;">${attr.attrAddr}</td>
                        <td style="width: 65px;text-align: center;vertical-align: middle;">${attr.attrIlla}</td>
                        <td style="width: 65px;text-align: center;vertical-align: middle;">${attr.attrTypeId}</td>
                        <td style="width: 65px;text-align: center;vertical-align: middle;">${attr.attrCostRange}</td>
                        <td style="width: 65px;text-align: center;vertical-align: middle;">${attr.attrBussTime}</td>
                        <td>
                         <button class="btn btn-outline-success" onclick="redirectToDetailPage(${attr.attrId})">
                          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"fill="currentColor" class="bi bi-pen" viewBox="0 0 16 16">
                          <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/>
                          </svg>
                          </button>
                        </td>
                        <td>
                         <button class="btn btn-outline-success" onclick="deleteAttraction(${attr.attrId})" value="刪除">
                          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"fill="currentColor" class="bi bi-pen" viewBox="0 0 16 16">
                          <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/>
                          </svg>
                            </button>
                        </td>

                    `;
                listStart_el.insertAdjacentElement('beforeend',row);

            });

        } catch (error) {
            console.error('Error:', error);
        }
    };
    $(".findAllAttraction").click(findAllAttraction);

//透過名稱找出所有包含關鍵字的景點
        var page ;
    $("#loadAttractions").click(function () {
        searchAttraction();
    });

    $("#page").change(function(){
        $("#pageChangeSubmit").click(function(){
            searchAttraction();
        });
    });

    async function searchAttraction(){
    const container = document.getElementById("attrTarget"); // 替换 "container" 为您的容器元素的 ID
        const elementToDelete = document.getElementById("elementToDelete"); // 替换 "elementToDelete" 为要保留的特定元素的 ID

        // 遍历容器中的所有子元素并删除除特定元素外的所有元素
        const childElements = container.children;
        for (let i = childElements.length - 1; i >= 0; i--) {
            const child = childElements[i];
            if (child !== elementToDelete) {
                container.removeChild(child);
            }
        }

        var baseUrl = window.location.protocol + "//" + window.location.host + window.location.pathname;
        var attrName = $("#attractionName").val();
        var pageSize = $("#pageSize").val();
        const page_el = $("#page");
        page = $("#page").val() -1;//校正頁數與Pageable的差

        try {
        ///attr/{attrName}/{pageSize}/{page}
        //可簡化
            var response = await fetch('getAttrsByName/' + attrName );
            var attrList = await response.json();
            page_el.max = attrList.length / pageSize + 1;
            console.log(page_el.max);
            response = await fetch('attr/' + attrName + '/' + pageSize + '/' + page);
            attrList = await response.json();
            console.log(attrList);
            const listStart_el = document.querySelector("#attrTarget");
            let countNum = page * pageSize;
            attrList.forEach(attr => {
                const row = document.createElement("tr");
                // attr_id, attr_veri_sta, attr_sta, attr_name, attr_addr,
                // attr_lon, attr_lat, attr_illa, attr_type_id, attr_buss_time, attr_cost_range, attr_rep
                // 1	1	1	Attraction 1	123 Main St	12.345	67.89
                // Description for Attraction 1	1	9:00 AM - 5:00 PM	2	Representative for Attraction 1
                row.innerHTML = `
                        <td >${++countNum}</td>
                        <td >${attr.attrName}</td>
                        <td >${attr.attrAddr}</td>
                        <td >${attr.attrIlla}</td>
                        <td >${attr.attrTypeId}</td>
                        <td >${attr.attrCostRange}</td>
                        <td >${attr.attrBussTime}</td>
                        <td>
                         <button class="btn btn-outline-success" onclick="redirectToDetailPage(${attr.attrId})">
                          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"fill="currentColor" class="bi bi-pen" viewBox="0 0 16 16">
                          <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/>
                          </svg>
                          </button>
                        </td>
                    `;
                listStart_el.insertAdjacentElement('beforeend',row);

            });

        } catch (error) {
            console.error('Error:', error);
        }

    }

    function redirectToDetailPage(attrId) {
          var newPageUrl = `AttractionDetails.html?attrId=${attrId}`;
          window.location.href = newPageUrl;
    }

    async function deleteAttraction(attrId){
        alert("準備刪除 ")
        const response = await fetch('deleteAttraction/' + attrId);
        alert("刪除景點成功");
        location.reload();
    }

