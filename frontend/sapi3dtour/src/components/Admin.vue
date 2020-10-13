<template>
    <v-container class="justify-center" >
        <v-row>
            <v-card id="card" width="550" class="mx-3 my-3" >
                <v-card-title> Felhasználó hozzáadása </v-card-title>
                <v-divider class="mx-5 my-3"></v-divider>
                <v-form ref="form" class="mx-5 " lazy-validation>
                    <v-flex>
                        <v-text-field class="ml-5 my-5" type="name" name="name" v-model="name" label="Új felhasználó neve" color="grey" dense
                        :rules="[ value =>!! value || 'A felhasználó név megadása kötelező!']"/>
                    </v-flex>
                    <v-flex>
                        <v-text-field class="ml-5" type="e-mail" name="e-mail" v-model="email" label="E-mail" color="grey" dense
                            :rules="[ value =>!! value || 'E-mail cím megadása kötelező!', value => /.+@.+\..+/.test(value) || 'E-mail cím helytelen']"/>
                    </v-flex>
                    <v-flex>
                        <v-text-field class="ml-5" type="phonenumber" name="phonenumber" v-model="phonenumber" label="Telefonszám"
                            color="grey" :rules="[ value =>!! value || 'Telefonszám megadása kötelező!',
                                                    value => /^\d{10}$/.test(value) || 'A telefonszám megadása csak számokkal történhet!']"/>
                    </v-flex>
                    <v-flex>
                        <v-select type="visibility" name="visibility" v-model="visibility" class="ml-5" :items="visibilityList"
                            label="Láhatósági jog" color="grey" item-color="grey"
                            :rules="[ value =>!! value || 'Láthatósági jog megadása kötelező!']"/>
                    </v-flex>
                    <v-card-actions class="justify-center"> 
                        <v-btn color="#2B405D" @click="validateUser" outlined text class="mr-4" >Hozzáadás</v-btn>
                    </v-card-actions>
                    <transition >
                        <v-list-item v-if="loadingButton" >
                            <v-list-item-icon  >
                                <v-icon color="#2B405D" >{{ regIcon }}</v-icon>
                            </v-list-item-icon>
                            <v-list-item-content >
                                <v-list-item-title >{{ registartionMsg }}</v-list-item-title>
                            </v-list-item-content>
                        </v-list-item>
                    </transition>
                </v-form>
            </v-card>
            <v-card id="card" width="550" class="mx-3 my-3">
                <v-card-title> Felhasználó törlése </v-card-title>
                <v-divider class="mx-5 my-3"></v-divider>
                <v-form ref="form" class="mx-5" lazy-validation>
                    <v-flex>
                        <v-subheader>Válaszd ki a törlendő Felhasználót!</v-subheader>
                    </v-flex>
                    <v-flex>
                        <!-- <v-select v-model="select" :hint="`${select.email}`" :items="items1" item-text="email" item-value="email"
                            label="Válassz!" persistent-hint return-object single-line color="grey"></v-select> -->
                    </v-flex>
                    <v-card-actions class="justify-center">
                        <v-btn color="#2B405D" outlined text  class="mr-4" >Törlés</v-btn>
                    </v-card-actions>
                </v-form>
            </v-card>
        </v-row>
    </v-container>
</template>

<script>
import AuthRequest from "@/services/AuthService";
import axios from "axios";

export default {
    name: 'Admin',
    data () {
        return {
            name: "",
            email: "",
            password: "",
            phonenumber: "",
            visibility: "",
            visibilityList: ["Admin", "Felhasználó"],
            show: false,
            loadingButton: false,
            regIcon: "",
            registartionMsg: ""
        };
    },
    methods:{
        validateUser(){
            if (this.$refs.form.validate()) {
                this.registration();
            }
        },
        registration(){
            AuthRequest.registerUser({
                fullName : this.name,
                emailAddress : this.email,
                phoneNumber : this.phonenumber,
                authority : this.visibility
            }).then((res)=>{
                this.registartionMsg = "Az új felhasználó sikeresen hozzáadodott!";
                this.loadingButton = true;
                this.regIcon = "fas fa-check";
                setTimeout(() => (this.loadingButton = true),
                                3000);
            }).catch((err)=>{
                this.registartionMsg = "Az új felhasználó hozzáadása nem sikerült!";
                this.regIcon = "fas fa-times";
                this.loadingButton = true;
                setTimeout(() => (this.loadingButton = false),
                                3000);
            })
        }
    }
}
</script>

<style>
    #card {
        background-color: #E1E1DE;
        color: #2B405D;
    }
    #ListItem {
        color: #2B405D;
    }
</style>