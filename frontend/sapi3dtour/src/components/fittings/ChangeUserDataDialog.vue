<template>
    <v-dialog v-model="dialog" width="700">
        <template v-slot:activator="{ on }">
            <v-btn v-on="on" outlined text class="mt-5">Adatok szerkesztése</v-btn>
        </template>
        <v-card class="mt-5" id="card">
            <v-card-title> Személyes adatok változtatása </v-card-title>
            <v-form ref="form" class="mx-5" lazy-validation>
                <v-text-field color="grey" label="Név" required v-model="full_name" 
                    :rules="[ value =>!! value || 'A felhasználó név megadása kötelező!']"> </v-text-field>
                <v-text-field color="grey" label="E-mail" required v-model="email" 
                    :rules="[ value =>!! value || 'E-mail cím megadása kötelező!', value => /.+@.+\..+/.test(value) || 'E-mail cím helytelen',]"> </v-text-field>
                <v-text-field color="grey" label="Telefonszám" required v-model="phone_number"
                    :rules="[ value =>!! value || 'Telefonszám megadása kötelező!']" > </v-text-field>
                <v-card-actions> 
                    <v-spacer></v-spacer>
                    <v-btn color="#2B405D" outlined text class="mr-4" @click="validateData"> Szerkesztés </v-btn>
                    <v-btn color="#2B405D" outlined text @click="dialog = false"> Vissza </v-btn>
                </v-card-actions>
            </v-form>
        </v-card>
  </v-dialog>
</template>

<script>

import AuthRequest from "@/services/AuthService";
import axios from "axios";

export default {
    name: "ChangeUserData",
    data() {
        this.getUserData();
        return {
            dialog: false,
            show: false,
            created_at: "",
            email: "",
            full_name: "",
            phone_number: "",
            status: "",
        };
    },
    methods: {
        getUserData() {
            const userid = localStorage.getItem("userid");
            AuthRequest.getUser(userid).then((res)=>{
                this.created_at = res.data.createdAt;
                this.email = res.data.emailAddress;
                this.full_name = res.data.fullName;
                // this.status = response.status;
                this.phone_number = res.data.phoneNumber;
            })
        },
        validateData(){
            if (this.$refs.form.validate()) {
                this.updateUser();
            }
        },
        async updateUser(){
            const userid = localStorage.getItem("userid");
            const response = await AuthRequest.updateAdmin({
                id: userid,
                fullName: this.full_name,
                emailAddress: this.email,
                phoneNumber: this.phone_number,
            });
        }
    },
};
</script>
<style>
</style>