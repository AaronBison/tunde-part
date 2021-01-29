<template>
    <div id="app">
      <v-app-bar prominent src="https://cloudflare1.360gigapixels.com/pano/alienrc/00550669_vegsopano.jpg/equirect_crop_3_1/6.jpg"/>
      <v-app id="inspire" style="background-color: #F7F7F7">
        <v-layout>
          <v-navigation-drawer style="background-color: #F7F7F7" :temporary="!mini" :mini-variant.sync="mini" app permanent>
            <v-list>
              <v-btn @click.stop="mini = !mini" icon>
                <v-icon>mdi-chevron-left</v-icon>
              </v-btn>
            </v-list>
            <v-divider/>
            <v-list dense>
              <LoginDialog />
              <v-list-item v-for="item in tabs" :key="item.title" router :to="item.route" link>
                <v-list-item-icon>
                  <v-icon>{{ item.icon }}</v-icon>
                </v-list-item-icon>
                <v-list-item-content>
                  <v-list-item-title>{{ item.title }}</v-list-item-title>
                </v-list-item-content>
              </v-list-item>
            </v-list>
          </v-navigation-drawer>
          <v-container class="justify-center">
            <router-view  />
          </v-container>
        </v-layout>
      </v-app>
    </div>
</template>

<script>

import LoginDialog from "./dialogs/LoginDialog"

export default {
  name: 'RootEvery',
  components: {LoginDialog},
  data () {
    return {
      mini: true,
      tabs: [
        {title: 'Model3D', route: '/model3d', icon:"fas fa-university"},
        {title: 'Fontos egyetemi helyek', route: '/department', icon:"fas fa-book-reader"},
      ]
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
