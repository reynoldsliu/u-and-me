//const btn_el = document.getElementById("loadAttraction");
//btn_el.addEventListener("click",function(){
//console.log("in fetch");
//            fetch("json-data")
//            .then(response => response.json())
//            .then(data => {
//                const outputDiv = document.getElementById("output");
//                outputDiv.innerHTML = JSON.stringify(data);
////                location='bootstrap12';
////                console.log(JSON.stringify(data));
////                sessionStorage.setItem('id', id);
//            })
//            .catch(error => console.error("Fetch error:", error));
//});
$(document).ready(function () {
        $("#loadAttraction").click(function () {
            var id = $("#attractionId").val();
            $.ajax({
                url: "/getAttraction/" + id,
                method: "GET",
                success: function (data) {
                    $("#attrName").text("Name: " + data.name);
                    $("#attrDescription").text("Description: " + data.description);
                    // You can continue to populate other attributes here
                },
                error: function () {
                    alert("Attraction not found");
                }
            });
        });
    });


