<template>
    <v-dialog v-model="dialog" width="700">
        <template v-slot:activator="{ on }">
            <v-btn v-on="on" outlined text class="mt-5">Adatok szerkesztése</v-btn>
        </template>
        <v-card class="mt-5" id="card">
            <v-card-title> Személyes adatok változtatása </v-card-title>
            <v-form ref="form" class="mx-5" lazy-validation>
                <v-text-field label="Név" required v-model="full_name" > </v-text-field>
                <v-text-field label="E-mail" required v-model="email" > {{ this.email }} </v-text-field>
                <v-text-field label="Telefonszám" required v-model="phone_number" > {{ this.phone_number }} </v-text-field>
                <v-card-actions> 
                    <v-spacer></v-spacer>
                    <v-btn outlined text class="mr-4" > Szerkesztés </v-btn>
                    <v-btn outlined text @click="dialog = false"> Vissza </v-btn>
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
            password: "",
            created_at: "",
            email: "",
            full_name: "",
            phone_number: "",
            status: "",
            password: "",
        };
    },
    methods: {
        async getUserData() {
            const response = await AuthRequest.getUser(103);
            this.created_at = response.created_at;
            this.email = response.email_address;
            this.full_name = response.full_name;
            this.status = response.status;
            this.phone_number = response.phone_number;
        }
    },
};
</script>
<style>
</style>