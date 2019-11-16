<template>
    <el-main>
      <el-table
        ref="multipleTable"
        :data="tableData"
        tooltip-effect="dark"
        style="width: 100%"
        @selection-change="handleSelectionChange">
        <el-table-column
          type="selection"
          width="55">
        </el-table-column>
        <el-table-column
          prop="id"
          label="编号"
          width="120">
        </el-table-column>
        <el-table-column
          label="生产日期"
          width="120">
          <template slot-scope="scope">{{ scope.row.borntime }}</template>
        </el-table-column>
        <el-table-column
          prop="name"
          label="姓名"
          width="120">
        </el-table-column>
        <el-table-column
          prop="price"
          label="价格"
          width="120">
        </el-table-column>
        <el-table-column
          prop="name"
          label="姓名"
          width="120">
        </el-table-column>
      </el-table>
      <el-pagination
        :page-count="pageData.pages"
        @current-change="handleCurrentChange"
       >
      </el-pagination>
      <div style="margin-top: 20px">
        <el-button @click="">切换第二、第三行的选中状态</el-button>
        <el-button @click="">取消选择</el-button>
      </div>
    </el-main>
</template>

<script>
  const axios = require("axios");
  const baseUrl = "http://localhost:8082";
    export default {
        name: "list",
        data(){
          return{
            tableData:[],
            pageData:{
              pageNo:0,
              pageSize:2
            }
          }

        },
      methods:{
        handleCurrentChange(val){
             this.pageData.pageNo=val;
             this.list();
        },list(){
          let self = this;
           axios({
             url:baseUrl+"/list",
             method:"get",
             params:this.pageData
           }).then(function (res) {
               console.log(res)
               self.tableData=res.data.list;
               self.pageData.pages = res.data.pages;
           })
        }, handleSelectionChange(val) {
          this.multipleSelection = val;
        }
      },created(){
          this.list()
      }
    }
</script>

<style scoped>

</style>
