<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="bootstrap08.css">

</head>
  <body>
    <div class="container">
      <div class="row">
        <div class="col-6 mx-auto my-5">
          <!-- 填寫表單 -->
          <form>
            <div class="mb-3">
              <label for="exampleInputEmail1" class="form-label">商品名稱</label>
              <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
            </div>
            <div class="mb-3">
              <label for="exampleInputPassword1" class="form-label">商品內容</label>
              <input type="password" class="form-control" id="exampleInputPassword1">
            </div>
            <div class="mb-3">
              <label for="exampleInputEmail1" class="form-label">商品價格</label>
              <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
            </div>
            <div class="mb-3">
              <label for="exampleInputPassword1" class="form-label">商品數量</label>
              <input type="password" class="form-control" id="exampleInputPassword1">
            </div>


            <!-- 下拉選單 -->
            <!-- 為了資料庫上縮減大小&易整理 設定 value="1" 為台北市的代號，真正送資料出去的是送1，而不是送台北市 -->

            <!-- <form action="">
              <select class="form-select mb-5" aria-label="Default select example">
                <option selected>選擇商品類別編號</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
              </select>
   -->
              <!-- 選擇檔案 -->
              <!-- 真正點擊的項目是lable，所以在lable裡的for屬性 要對應到上傳檔案input的id -->
              <!-- <div class="mb-5">
                <label for="formFile1" class="form-label">上傳商品照片1</label>
                <input class="form-control" type="file" id="formFile1">
              </div>
              <div class="mb-3">
                <label for="formFile2" class="form-label">上傳商品照片2</label>
                <input class="form-control" type="file" id="formFile2">
              </div>

            </form>-->
            <button type="submit" class="btn btn-primary">Submit</button>
          </form>
        </div>
      </div>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
  </body>
</html>