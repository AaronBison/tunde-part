<template>
    <div id="app">
      <v-app id="inspire">
      <v-app-bar color="#2B405D" prominent dark class="justify-center">
        <v-app-bar-title>3D virtuális túra a Sapientia Erdélyi Magyar Tudományegyetem Marosvásárhely-i karán</v-app-bar-title>
        <v-spacer></v-spacer>
        <UserDataDialog/>
        <LogOut/>
        <template v-slot:extension>
          <v-tabs align-with-title >
            <v-tab v-for="item in tabs" :key="item.title" router :to="item.route" link>{{ item.title }}</v-tab>
          </v-tabs>
        </template>
      </v-app-bar>
      <v-sheet id="scrolling-techniques-3" class="overflow-y-auto">
        <v-container>
          <router-view/>
        </v-container>
      </v-sheet>
      </v-app>
    </div>
</template>

<script>

import AuthRequest from "@/services/AuthService";

import ChangeUserDataDialog from "./dialogs/ChangeUserDataDialog"
import UserDataDialog from "./dialogs/UserDataDialog"
import LogOut from "./LogOut"

export default {
  name: 'RootAdmin',
  components:{ ChangeUserDataDialog, UserDataDialog,LogOut},
  data () {
    return {
      tabs: [
        {title: 'Beállítások', route: '/user/admin', icon:"fas fa-hammer"},
        {title: 'Model3D', route: '/user/model3d', icon:"fas fa-university"},
        {title: 'Fontos egyetemi helyek', route: '/user/department', icon:"fas fa-book-reader"},
      ]
    }
  },
  methods: {
    getUserData() {
      const userid = localStorage.getItem("userid");
      AuthRequest.getUser({id: userid}).then((res)=>{
        this.created_at = res.data.createdAt;
        this.email = res.data.emailAddress;
        this.full_name = res.data.username;
        this.status = localStorage.getItem("role");
        this.phone_number = res.data.phoneNumber;
      })
    }
  },
  mounted() {
    this.getUserData();
  },
}
</script>

<style>
    #card {
        background-color: #E1E1DE;
        color: #2B405D;
    }
</style>
