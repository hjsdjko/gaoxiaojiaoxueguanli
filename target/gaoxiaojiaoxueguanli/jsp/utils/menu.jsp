<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
var menus = [

	{
        "backMenu":[
            {
                "child":[
                    {
                        "buttons":[
                            "新增",
                            "修改",
                            "删除",
                        ],
                        "menu":"用户管理",
                        "menuJump":"列表",
                        "tableName":"yonghu"
                    }
                ],
                "menu":"用户管理"
            },
            {
                "child":[
                    {
                        "buttons":[
                            "新增",
                            "修改",
                            "删除",
                            "报表",
                        ],
                        "menu":"工作量管理",
                        "menuJump":"列表",
                        "tableName":"gongzuoliang"
                    }
                ],
                "menu":"工作量管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "新增",
                            "修改",
                            "删除",
                        ],
                        "menu":"核算管理",
                        "menuJump":"列表",
                        "tableName":"hesuan"
                    }
                ],
                "menu":"核算管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "新增",
                            "修改",
                            "删除",
                        ],
                        "menu":"教学日志管理",
                        "menuJump":"列表",
                        "tableName":"jiaoxueruzi"
                    }
                ],
                "menu":"教学日志管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "新增",
                            "修改",
                            "删除",
                        ],
                        "menu":"系统公告管理",
                        "menuJump":"列表",
                        "tableName":"xitonggonggao"
                    }
                ],
                "menu":"系统公告管理"
            }
        ],
        "frontMenu":[

        ],
        "roleName":"管理员",
        "tableName":"users"
    }
	,
	{
        "backMenu":[
            {
                "child":[
                    {
                        "buttons":[
                        ],
                        "menu":"工作量管理",
                        "menuJump":"列表",
                        "tableName":"gongzuoliang"
                    }
                ],
                "menu":"工作量管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                        ],
                        "menu":"核算管理",
                        "menuJump":"列表",
                        "tableName":"hesuan"
                    }
                ],
                "menu":"核算管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[
                            "新增",
                            "修改",
                        ],
                        "menu":"教学日志管理",
                        "menuJump":"列表",
                        "tableName":"jiaoxueruzi"
                    }
                ],
                "menu":"教学日志管理"
            }
            ,{
                "child":[
                    {
                        "buttons":[],
                        "menu":"系统公告管理",
                        "menuJump":"列表",
                        "tableName":"xitonggonggao"
                    }
                ],
                "menu":"系统公告管理"
            }
        ],
        "frontMenu":[

        ],
        "roleName":"教师",
        "tableName":"yonghu"
    }
];

var hasMessage = '';
