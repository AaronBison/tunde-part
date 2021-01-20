<template>
    <v-container class="justify-center" >
        <v-row>
            <AddUsers/>
            <DeleteUsers/>
        </v-row>
        <v-row>
            <InformationDepartmentAddUpdate/>
        </v-row>
    </v-container>
</template>

<script>
import AuthRequest from "@/services/AuthService";
import axios from "axios";
import AddUsers from "./userTasks/addUsers.vue";
import DeleteUsers from "./userTasks/deleteUser.vue"
import InformationDepartmentAddUpdate from "./userTasks/InfDepAddUpd.vue"

export default {
    name: 'Admin',
    components:{AddUsers, DeleteUsers,InformationDepartmentAddUpdate},
    data () {
        return {
            
        };
    }
}
</script>

<style>
    #card {
        background-color: #E1E1DE;
        color: #2B405D;
    }
</style>