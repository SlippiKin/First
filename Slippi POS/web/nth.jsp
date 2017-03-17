
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
 
         <title>Shelf</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">         
        <link href="css/inventorystyle.css" rel="stylesheet" type="text/css"/>        
        <script src="js/jquery.min.js" type="text/javascript"></script>       
        <script src="js/angular.min.js" type="text/javascript"></script>
        <script>
              window.onload = function () {

                
                //call ajax for month total
                $.ajax({
                    async: false,
                    url: "getFloorPlanFromAjax",
                    dataType: "text",
                    success: function (data) {
                        console.log("ajax return json " + data);
                        
                        var data = data;


                    }
                });
            };
        </script>
    </head>
    <body>



    </body>
</html>
