<template>
    <div>
        <v-container class="justify-center" >
            <v-row>
                <v-card id="card" width="550" class="mx-3 my-3" >
                    <v-card-title> Felhasználó hozzáadása </v-card-title>
                    <v-divider class="mx-5 my-3"></v-divider>
                    <v-form ref="form" class="mx-5" lazy-validation>
                        <v-flex>
                            <v-text-field class="ml-5" type="name" name="name" v-model="name" label="Új felhasználó neve" color="grey" dense
                            :rules="[ value =>!! value || 'A felhasználó név megadása kötelező!']"></v-text-field>
                        </v-flex>
                        <v-flex>
                            <v-text-field class="ml-5" type="e-mail" name="e-mail" v-model="email" label="E-mail" color="grey" dense
                            :rules="[ value =>!! value || 'E-mail cím megadása kötelező!', value => /.+@.+\..+/.test(value) || 'E-mail cím helytelen',]"/>
                        </v-flex>
                        <v-flex>
                            <v-text-field class="ml-5" name="password" v-model="password" label="Jelszó" color="grey"
                                :append-icon="show ? 'fas fa-eye' : 'fas fa-eye-slash'"
                                :type="show ? 'text' : 'password'"
                                @click:append="show = !show" required dense
                                :rules="[value => !!value || 'A jelszó megadása kötelező!', 
                                        value => /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{5,20}$/.test(value) || 'A jelszó helytelen' , 
                                        value => value.length >= 5 || 'Legalább 5 karakter hosszúságú kell legyen']"></v-text-field>
                        </v-flex>
                        <v-flex>
                            <v-text-field class="ml-5" type="phonenumber" name="phonenumber" v-model="phonenumber" label="Telefonszám"
                                color="grey" :rules="[ value =>!! value || 'Telefonszám megadása kötelező!']"></v-text-field>
                        </v-flex>
                        <v-flex>
                            <v-select type="visibility" name="visibility" v-model="visibility" class="ml-5" :items="visibilityList"
                                label="Láhatósági jog" color="grey" item-color="grey"
                                :rules="[ value =>!! value || 'Láthatósági jog megadása kötelező!']"/>
                        </v-flex>
                        <v-card-actions class="justify-center"> 
                            <v-btn color="#2B405D" @click="validateUser" outlined text class="mr-4" >Hozzáadás</v-btn>
                        </v-card-actions>
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
    </div>
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
            visibilityList: ["Admin", "Tanár", "Diák"],
            show: false
        };
    },
    methods:{
        validateUser(){
            if (this.$refs.form.validate()) {
                this.registerUser();
            }
        },
        async registerUser(){
            // var passwordHash = require('password-hash');
            // var hashedPassword = passwordHash.generate(this.password);
            // this.password = hashedPassword;
            // console.log(this.password)
            const response = await AuthRequest.addNewAdmin({
                fullName: this.name,
                emailAddress: this.email,
                password: this.password,
                phoneNumber: this.phonenumber,
                status: this.visibility,
                createdAt: Date.now()
            });
        }
    }
  }
</script>

<style>
    #card {
        background-color: #E1E1DE;
        color: #2B405D;
    }
</style>