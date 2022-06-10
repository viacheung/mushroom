<template>
  <div >
    <navbar/>
    <AppMain />
    <Footer />
  </div>
</template>

<script>
import Navbar from '../layout/Navbar'
import Footer from "./Footer";
import AppMain from "../views/AppMain";
export default {
  name: "Layout",
  components: {
    Navbar,
    Footer,
    AppMain
  },
}
</script>

<style scoped>

</style>
