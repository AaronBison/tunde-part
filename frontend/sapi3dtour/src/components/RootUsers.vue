<template>
    <div id="app">
      <v-app-bar prominent src="https://cloudflare1.360gigapixels.com/pano/alienrc/00550669_vegsopano.jpg/equirect_crop_3_1/6.jpg"/>
      <v-app id="inspire" style="background-color: #F7F7F7">
        <v-layout>
          <v-navigation-drawer style="background-color: #F7F7F7" :temporary="!mini" :mini-variant.sync="mini" app permanent>
            <v-list-item>
              <v-list-item-icon >
                <v-icon> {{ this.user_icon }} </v-icon>
              </v-list-item-icon>
              <v-layout column align-center>
                <v-list-item-title  class="subtitle-1 mt-5">{{ this.full_name }}</v-list-item-title>
                <v-list-item-subtitle class="mt-5">{{ this.status }}</v-list-item-subtitle>
                <v-list-item-subtitle>{{ this.email }}</v-list-item-subtitle>
                <v-list-item-subtitle>{{ this.phone_number }}</v-list-item-subtitle>
                <ChangeUserDataDialog />
              </v-layout>
              <v-btn @click.stop="mini = !mini" icon>
                <v-icon>mdi-chevron-left</v-icon>
              </v-btn>
            </v-list-item>
            <v-divider class="mt-5"/>
            <v-list dense>
              <v-list-item v-for="item in tabs" :key="item.title" router :to="item.route" link>
                <v-list-item-icon>
                  <v-icon>{{ item.icon }}</v-icon>
                </v-list-item-icon>
                <v-list-item-content>
                  <v-list-item-title>{{ item.title }}</v-list-item-title>
                </v-list-item-content>
              </v-list-item>
            </v-list>
            <v-divider/>
            <LogOut/>
          </v-navigation-drawer>
          <v-container class="justify-center">
            <router-view  />
          </v-container>
        </v-layout>
      </v-app>
    </div>
</template>

<script>

import AuthRequest from "@/services/AuthService";
import axios from "axios";

import ChangeUserDataDialog from "./dialogs/ChangeUserDataDialog"
import LogOut from "./LogOut"

export default {
  name: 'RootAdmin',
  components:{ ChangeUserDataDialog, LogOut},
  data () {
    return {
      mini: true,
      created_at: "",
      email: "",
      full_name: "",
      phone_number: "",
      status: "",
      user_icon: "fas fa-user",
      tabs: [
        {title: 'Beállítások', route: '/user/admin', icon:"fas fa-hammer"},
        {title: 'Model3D', route: '/user/model3d', icon:"fas fa-university"},
        {title: 'Tanszékek', route: '/user/department', icon:"fas fa-book-reader"},
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
