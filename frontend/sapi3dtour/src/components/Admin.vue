<template>
    <div>
        <v-container class="justify-center" >
            <v-row>
            <v-card id="card" width="550" class="mx-3 my-3" >
                <v-card-title> Felhasználó hozzáadása </v-card-title>
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
                            :rules="[ value => value.length >= 5 || 'Legalább 5 karakter hosszúságú kell legyen']"
                        ></v-text-field>
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
            <!-- <v-card id="card" width="550" class="mx-3 my-3" >
                <v-card-title> Új admin hozzáadása2 </v-card-title>
                <v-form ref="form" class="mx-5" lazy-validation>
                    <v-text-field label="Új admin neve" color="grey" required></v-text-field>
                    <v-text-field label="E-mail" color="grey" required ></v-text-field>
                    <v-text-field name="password" color="grey" v-model="password" label="Jelszó"
                        :append-icon="show ? 'fas fa-eye' : 'fas fa-eye-slash'" :type="show ? 'text' : 'password'"
                        counter="24" @click:append="show = !show" />
                    <v-text-field label="Telefonszám" color="grey" required></v-text-field>
                    <v-radio-group label="Státusz:" color="grey" column>
                        <v-radio label="Admin" value="radio-1" color="grey" ></v-radio>
                        <v-radio label="Tanár" value="radio-2" color="grey" ></v-radio>
                        <v-radio label="Diák" value="radio-3" color="grey" ></v-radio>
                    </v-radio-group>
                    <v-card-actions class="justify-center"> 
                        <v-btn color="#2B405D" outlined text class="mr-4" >Hozzáadás</v-btn>
                        <v-btn color="#2B405D" outlined text class="mr-4" >Elvetés</v-btn>
                    </v-card-actions>
                </v-form>
            </v-card> -->
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
            var passwordHash = require('password-hash');
            var hashedPassword = passwordHash.generate(this.password);
            this.password = hashedPassword;
            console.log(this.password)
            const response = await AuthRequest.addNewAdmin({
                full_name: this.name,
                email_address: this.email,
                password: this.password,
                phone_number: this.phonenumber,
                status: this.visibility,
                created_at: Date.now()
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