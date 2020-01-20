<template>
  <div id="app">
    <Header/>
    <Navigation/>
    <CurrentBaner/>
    <BodyPage/>
    <Footer/>
  </div>
</template>
<script>
import Header from '@/components/unitComponents/Header'
import Footer from '@/components/unitComponents/Footer'
import Navigation from '@/components/unitComponents/Navigation'
import CurrentBaner from '@/components/unitComponents/CurrentBaner'
import BodyPage from '@/components/unitComponents/BodyPage'
export default {
  name: 'mainPageComponent',
  components: {
    Header,
    Navigation,
    CurrentBaner,
    BodyPage,
    Footer
  }
}
</script>

<style scoped>

</style>
