const base = {
    get() {
        return {
            url : "http://localhost:8080/yiqingdakapingce/",
            name: "yiqingdakapingce",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/yiqingdakapingce/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "疫情打卡健康评测系统"
        } 
    }
}
export default base
