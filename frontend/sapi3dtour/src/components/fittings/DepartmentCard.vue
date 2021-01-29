<template>
    <v-card id="card" width="1000" class="mx-3 my-3" elevation="10" >
        <v-card-title class="justify-center">
            <a v-bind:href="card.link" target="_blank">{{ card.departmentName }}</a>
         </v-card-title>

        <v-divider class="mx-12"></v-divider>

        <v-card-subtitle> Szakok </v-card-subtitle>

        <BranchList v-for="branch in branches" :key="branch.departmentName" :branch="branch"  />

        <v-divider class="mx-12"></v-divider>

        <v-card-subtitle > Egyebek </v-card-subtitle>

        
    </v-card>
</template>

<script>
import BranchList from "./BranchesList"
import GeneralTasks from "@/services/generalTasks"

export default {
    name: 'DepartmentCard',
    components: {BranchList},
    props: ["card"],
    data () {
        return {
            branches:null
        };
    },
    methods: {
        getBranches()
        {
            GeneralTasks.getBranches(
                {
                    departmentName : this.card.departmentName
                }
            ).then((res)=>{
                this.branches = res.data;
            }).catch((err)=>{
                this.branches = null;
            })
        }
    },
    mounted()
    {
        this.getBranches();
    }
}
</script>

<style>
    #card {
        background-color: #E1E1DE;
        color: #2B405D;
    }
</style>