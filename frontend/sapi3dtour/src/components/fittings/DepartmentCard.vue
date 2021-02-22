<template>
    <v-card id="card" width="1000" class="mx-3 my-3" elevation="10" >
        <v-card-title class="justify-center">
            <a v-bind:href="card.link" target="_blank">{{ card.departmentName }}</a>
            &nbsp;&nbsp;&nbsp;
            <v-tooltip bottom>
                <template v-slot:activator="{ on, attrs }">
                    <v-btn v-bind="attrs" v-on="on" icon @click="takeToThere">
                        <v-icon>fas fa-map-marked-alt</v-icon>
                    </v-btn>     
                </template>
                <span>Vigyél el!</span>
            </v-tooltip>
        </v-card-title>
        <v-divider class="mx-12"></v-divider>
        <v-card-subtitle v-if="branches != null"> Alrészlegek </v-card-subtitle>
        <BranchList v-for="branch in branches" :key="branch.branchName" :branch="branch"/>
        <v-divider v-if="branches != null" class="mx-12"></v-divider>
        <v-card-subtitle v-if="branches != null" > Egyebek </v-card-subtitle>
        <OtherBranchList v-for="otherBranch in othersBranch" :key="otherBranch.departmentName" :otherBranch="otherBranch"/>
    </v-card>
</template>

<script>
import BranchList from "./BranchesList"
import OtherBranchList from "./OthersBranchList"
import GeneralTasks from "@/services/generalTasks"

export default {
    name: 'DepartmentCard',
    components: {BranchList, OtherBranchList},
    props: ["card"],
    data () {
        return {
            branches:null,
            othersBranch:null
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
                if(res.data.length != 0)
                {
                    this.branches = res.data;
                }
                else
                {
                    this.othersBranch = [];
                }
            }).catch((err)=>{
                this.branches = null;
            });
        },
        getOtherBranches()
        {
            GeneralTasks.getOtherBranches(
                {
                    departmentName : this.card.departmentName
                }
            ).then((res)=>{
                if(res.data.length != 0)
                {
                    this.othersBranch = res.data;
                }
                else{
                    this.othersBranch = null;
                }
            }).catch((err)=>{
                this.othersBranch = null;
            });
        },
        takeToThere()
        {
            switch (this.card.departmentName){
				case "Matematika-Informatika Tanszék":
                    this.$router.push({ path: '/model3d', query: { road: 'mt' } })
                    break;
                case "Dékáni hivatal":
                    this.$router.push({ path: '/model3d', query: { road: 'dh' } })
                    break;
                default:
					break;
            }
        }
    },
    mounted()
    {
        this.getBranches();
        this.getOtherBranches();
    }
}
</script>

<style>
    #card {
        background-color: #E1E1DE;
        color: #2B405D;
    }
</style>