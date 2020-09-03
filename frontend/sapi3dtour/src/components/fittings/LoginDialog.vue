<template>
  <v-dialog v-model="dialog" width="700">
    <template v-slot:activator="{ on }">
      <v-list-item v-on="on" v-for="item in tabs" :key="item.title" router :to="item.route" link>
        <v-list-item-icon>
          <v-icon>{{ item.icon }}</v-icon>
        </v-list-item-icon>
        <v-list-item-content>
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </template>
    <v-card id="card" :loading="loadingCard">
      <v-card-title>Bejelentkezés</v-card-title>
      <v-divider class="mx-5"></v-divider>
      <v-container fluid grid-list-lg class="pt-3">
        <v-form ref="form" lazy-validation>
          <v-layout row wrap>
            <v-flex>
              <v-text-field class="mx-5" type="email" name="email" v-model="email" label="E-mail cím" color="grey"
                prepend-icon="fas fa-user" @keyup.enter="validateUser" 
                :rules="[ value =>!! value || 'E-mail cím megadása kötelező!', value => /.+@.+\..+/.test(value) || 'E-mail cím helytelen',]"
              ></v-text-field>
            </v-flex>
            <v-flex xs12>
              <v-text-field name="password" v-model="password" class="mx-5" label="Jelszó" color="grey"
                :append-icon="show ? 'fas fa-eye' : 'fas fa-eye-slash'" :type="show ? 'text' : 'password'"
                @keyup.enter="validateUser" @click:append="show = !show"
                :rules="[value => !!value || 'A jelszó megadása kötelező!', 
                        value => /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{5,20}$/.test(value) || 'A jelszó helytelen' , 
                        value => value.length >= 5 || 'Legalább 5 karakter hosszúságú kell legyen']"
                prepend-icon="fas fa-lock"/>
              </v-flex>
          </v-layout>
        </v-form>
        <v-card-actions class="justify-center">
          <v-btn outlined color="#2B405D" class="mr-4" @click="validateUser" text>Bejelentkezés</v-btn>
          <v-btn color="#2B405D" outlined text @click="dialog = false"> Vissza </v-btn>
        </v-card-actions>
      </v-container>
      </v-card>
      <v-snackbar v-model="loginSuccesSnackbar" absolute rounded="pill" color="grey" class="mb-5">
        {{ loginSuccesMsg }}
        <v-btn text @click="loginSuccesSnackbar = false">Close</v-btn>
      </v-snackbar>
      <v-snackbar v-model="loginFailedSnackbar" class="mb-5">
        {{ loginFailedMsg }}
        <v-btn text @click="loginFailedSnackbar = false">Close</v-btn>
      </v-snackbar>
  </v-dialog>
</template>

<script>
  import AuthRequest from "@/services/AuthService";
  import axios from "axios";
  export default {
    name: 'LoginDialog',
    data() {
      return {
        dialog: false,
        email: "",
        password: "",
        show: false,
        loadingCard: false,
        loadingButton: false,
        show: false,
        loginFailedMsg: "",
        loginSuccesMsg: "",
        loginFailedSnackbar: false,
        loginSuccesSnackbar: false,
        tabs: [
          {title: 'Bejelentkezés', icon:"fas fa-sign-in-alt"},
        ]
      };
    },
    methods: {
      toAdmin() {
        this.loadingCard = "grey";
        setTimeout(
          () => ((this.loadingCard = false), this.$router.push({ path: "/admin" })),
          1000
        );
    },
      validateUser() {
        if (this.$refs.form.validate()) {
          this.loginUser();
        }
      },
      async loginUser(){
        this.loadingCard = "grey";
        const response = await AuthRequest.loginVerification({
          emailAddress: this.email,
          password: this.password
        })
        if (response.data.error){
          this.loginFailedMsg = response.data.error;
          setTimeout(
            () => (this.loginSuccesSnackbar = false),
            (this.loginFailedSnackbar = true),
            1000
          );
        } else {
          this.loginSuccesMsg = "Sikeres bejelentkezés!";
          setTimeout(
            () => (this.loginFailedSnackbar = false),
            (this.loginSuccesSnackbar = true),
            1000
          );
          localStorage.setItem("userid", response.data.id);
          localStorage.setItem("token", response.data.token);
          this.toAdmin();
        }
        setTimeout(() => (this.loadingCard = false), 1000);
      }
    },
  }
</script>
<style >
  #card {
    background-color: #E1E1DE;
    color: #2B405D;
  }
</style>