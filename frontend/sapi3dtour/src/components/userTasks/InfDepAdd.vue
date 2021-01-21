<template>
    <v-form  ref="form" class="mx-5 " lazy-validation>
        <v-flex>
            <v-text-field class="ml-5" type="name" name="name" v-model="name" label="Részleg neve" dense
                :rules="[ value =>!! value || 'A részleg név megadása kötelező!']"/>
        </v-flex>
        <v-flex>
            <v-text-field class="ml-5" type="phonenumber" name="phonenumber" v-model="phonenumber" label="Telefonszám"
                :rules="[ value =>!! value || 'Telefonszám megadása kötelező!',
                                    value => /^\d{10}$/.test(value) || 'A telefonszám megadása csak számokkal történhet!']"/>
        </v-flex>
        <v-flex>
                <v-text-field class="ml-5" type="e-mail" name="e-mail" v-model="email" label="E-mail" color="grey" dense
                    :rules="[ value =>!! value || 'E-mail cím megadása kötelező!', value => /.+@.+\..+/.test(value) || 'E-mail cím helytelen']"/>
        </v-flex>
        <v-flex>
            <v-textarea class="ml-5" name="description" v-model="description" label="Leírás" :rules="[ value =>!! value || 'A leírás megadása kötelező!']"/>
        </v-flex>
        <v-card-actions class="justify-center"> 
            <v-btn color="#2B405D" outlined text class="mr-4" @click="newDepartment" >Hozzáadás</v-btn>
        </v-card-actions>
        <transition >
            <v-list-item v-if="loadingButtonX" >
                <v-list-item-icon>
                    <v-icon color="red" >{{ icon }}</v-icon>
                </v-list-item-icon>
                <v-list-item-content >
                    <v-list-item-title class="red--text" >{{ departmentAddMsg }}</v-list-item-title>
                </v-list-item-content>
            </v-list-item>
            </transition>
            <transition >
                <v-list-item v-if="loadingButtonTick" >
                <v-list-item-icon>
                    <v-icon color="green" >{{ icon }}</v-icon>
                </v-list-item-icon>
                <v-list-item-content >
                    <v-list-item-title class="green--text" >{{ departmentAddMsg }}</v-list-item-title>
                </v-list-item-content>
            </v-list-item>
        </transition>
    </v-form>
</template>

<script>
import AuthRequest from "@/services/AuthService";
import UserTasks from "@/services/userTasks";
import axios from "axios";

export default {
    name: 'InformationDepartmentAdd',
    data () {
        return {
            name: "",
            phonenumber: "",
            email: "",
            description: "",
            loadingButtonX: false,
            loadingButtonTick:false,
            icon: "",
            departmentAddMsg: ""
        };
    },
    methods:{
        newDepartment()
        {
            UserTasks.addDepartment({
                departmentName : this.name,
                emailAddress : this.email,
                phoneNumber : this.phonenumber,
                description : this.description
            }).then((res) =>{
                console.log(res)
                this.departmentAddMsg = "Az új részleg sikeresen hozzáadodott!";
                this.loadingButtonTick = true;
                this.icon = "fas fa-check";
                setTimeout(() => (this.loadingButtonTick = false),3000);
            }).catch((err)=>{
                console.log(err)
                this.departmentAddMsg = "Az új részleg hozzáadása nem sikerült!";
                this.icon = "fas fa-times";
                this.loadingButtonX = true;
                setTimeout(() => (this.loadingButtonX = false), 3000);
            });
        }
    },
}
</script>

<style>
    #card {
        background-color: #E1E1DE;
        color: #2B405D;
    }
</style>