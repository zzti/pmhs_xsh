﻿<!DOCTYPE html>
<!--[if lt IE 7]> <html lang="zh-cn" ng-app="tasksystem" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]> <html lang="zh-cn" ng-app="tasksystem" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]> <html lang="zh-cn" ng-app="tasksystem" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]> --> <html lang="zh-cn" ng-app="tasksystem" class="no-js">  <!--<![endif]-->
<head>
    <meta charset="utf-8"/>
    <title>恒辰公卫重点人群管理系统</title>
    <meta name="description" content="恒辰公卫重点人群管理系统"/>
    <meta name="viewport" content="width=device-width,height=device-height, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>--%>
    <link rel="shortcut icon" href="lib/beyond/img/favicon.png" type="image/x-icon">

    <!--Basic Styles-->
    <link href="lib/beyond/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="lib/beyond/css/font-awesome.min.css" rel="stylesheet"/>
    <link href="lib/beyond/css/weather-icons.min.css" rel="stylesheet"/>

    <link id="beyond-link" href="lib/beyond/css/beyond.min.css" rel="stylesheet"/>

    <link href="lib/beyond/css/demo.min.css" rel="stylesheet"/>
    <link href="lib/beyond/css/typicons.min.css" rel="stylesheet"/>
    <link href="lib/beyond/css/animate.min.css" rel="stylesheet"/>
    <link href="lib/uigrid/ui-grid.min.css" rel="stylesheet"/>
    <link href="lib/uiselect/select.min.css" rel="stylesheet"/>
    <link href="lib/jstree/themes/default/style.min.css" rel="stylesheet"/>
    <link href="lib/scrollingtab/scrolling-tabs.min.css" rel="stylesheet"/>
    <link href="css/index.css" rel="stylesheet"/>


    <!--Skin Script: Place this script in head to load scripts for skins and rtl support-->

    <style>
        [ng-cloak] {
            display: none;
        }
    </style>
</head>
<!-- /Head -->
<!-- Body -->
<body ng-cloak>
<!-- Loading Container -->
<div class="loading-container">
    <div class="loader"></div>
</div>
<!--  /Loading Container -->
<!-- Navbar -->

<!-- /Navbar -->
<!-- Main Container -->
<ng-view>

</ng-view>

<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript' src='/dwr/interface/systemInformationUtils.js'></script>
<script type='text/javascript' src='/dwr/interface/CommonExamService.js'></script>
<%--<script src="lib/beyond/js/jquery-2.0.3.min.js"></script>--%>
<script src="lib/jquery-1.11.2.min.js"></script>
<script src="lib/jstree/jstree.min.js"></script>
<script src="lib/script.min.js"></script>
<script src="lib/beyond/js/bootstrap.min.js"></script>
<script src="lib/beyond/js/slimscroll/jquery.slimscroll.min.js"></script>
<script src="lib/beyond/js/skins.js"></script>
<!--Beyond Scripts-->
<script src="lib/beyond/js/beyond.min.js"></script>

<!--Page Related Scripts-->
<script src="lib/beyond/js/bootbox/bootbox.js"></script>


<script type='text/javascript' src='lib/angular/angular.min.js'></script>
<script type='text/javascript' src='lib/angular/angular-animate.min.js'></script>
<script type='text/javascript' src='lib/angular/angular-touch.min.js'></script>
<%--<script type='text/javascript' src='lib/angular/angular-aria.min.js'></script>--%>
<%--<script type='text/javascript' src='lib/angular/angular-cookies.min.js'></script>--%>
<%--<script type='text/javascript' src='lib/angular/angular-loader.min.js'></script>--%>
<%--<script type='text/javascript' src='lib/angular/angular-messages.min.js'></script>--%>
<%--<script type='text/javascript' src='lib/angular/angular-resource.min.js'></script>--%>
<script type='text/javascript' src='lib/angular/angular-route.min.js'></script>
<script type='text/javascript' src='lib/ngbootstrap/ui-bootstrap-tpls-0.12.1.min.js'></script>

<script type='text/javascript' src='lib/uigrid/ui-grid.min.js'></script>
<script type='text/javascript' src='lib/uiselect/select.min.js'></script>

<%--<script type='text/javascript' src='lib/angular/angular-touch.min.js'></script>--%>

<script type='text/javascript' src='lib/jstree/jsTree.directive.js'></script>
<script src="js/version/version.js"></script>
<script src="js/version/version-directive.js"></script>
<script src="js/version/interpolate-filter.js"></script>

<script type='text/javascript' src='js/index.js'></script>
<script type='text/javascript' src='app/login/login.js'></script>
<script type='text/javascript' src='app/main/main.js'></script>

</body>
</html>
