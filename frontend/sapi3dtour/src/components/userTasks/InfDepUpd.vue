<template>
    <transition >
        <v-form ref="form" class="mx-5 my-3" lazy-validation>
            <v-combobox v-model="selectedItem" class="ml-5" color="grey" dense :items="departments" 
                        label="Válaszd ki a törlendő részleget!" hide-selected persistent-hint small-chips></v-combobox>
            <v-card-actions class="justify-center">
                <v-btn color="#2B405D" outlined text class="mr-4" @click="researchDepartment">Részleg keresése</v-btn>
            </v-card-actions>
        </v-form>
        <v-form v-if="updateDep" ref="form" class="mx-5 " lazy-validation>
            <v-flex>
                <v-text-field class="ml-5" type="name" name="name" v-model="name" label="Részleg neve" color="grey" dense
                    :rules="[ value =>!! value || 'A részleg név megadása kötelező!']"/>
            </v-flex>
            <v-flex>
                <v-text-field class="ml-5" type="phonenumber" name="phonenumber" v-model="phonenumber" label="Telefonszám"
                    color="grey" :rules="[ value =>!! value || 'Telefonszám megadása kötelező!',
                                        value => /^\d{10}$/.test(value) || 'A telefonszám megadása csak számokkal történhet!']"/>
            </v-flex>
            <v-flex>
                <v-text-field class="ml-5" type="e-mail" name="e-mail" v-model="email" label="E-mail" color="grey" dense
                    :rules="[ value =>!! value || 'E-mail cím megadása kötelező!', value => /.+@.+\..+/.test(value) || 'E-mail cím helytelen']"/>
            </v-flex>
            <v-flex>
                <v-text-field class="ml-5" type="text" name="description" v-model="description" label="Leírás" color="grey" dense
                    :rules="[ value =>!! value || 'A leírás megadása kötelező!']"/>
            </v-flex>
            <v-card-actions class="justify-center"> 
                <v-btn color="#2B405D" outlined text class="mr-4" >Hozzáadás</v-btn>
            </v-card-actions>
        </v-form>
    </transition>
</template>

<script>
import AuthRequest from "@/services/AuthService";
import UserTasks from "@/services/userTasks";
import axios from "axios";

export default {
    name: 'InformationDepartmentUpd',
    data () {
        return {
            name: null,
            phonenumber: null,
            email: null,
            description: null,
            selectedItem: null,
            departments: null,
            updateDep:false,
        };
    },
    methods:{
        researchDepartment()
        {
            this.updateDep = true;
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