'use strict'
import React from 'react';
import {
  Platform,
  ScrollView,
  StyleSheet,
  Text,
  TouchableOpacity,
  View,
  Image
} from 'react-native';
import { QRCodeScanner } from '../components/QRCodeScanner';

export default class HomeScreen extends React.Component {
   state ={
     qrCodeScanner: false
   }
  _handlePressUrl = () => {
    this.setState({qrCodeScanner: true});
  };

  scanrQRcode() {
    if(this.state.qrCodeScanner) return <QRCodeScanner navigation={this.props.navigation}/>
    else return
  }
  
  render() {

    return (
      <View style={styles.container}>
        <ScrollView style={styles.container} contentContainerStyle={styles.contentContainer}>
          <View style={styles.getStartedContainer}>
            <Text style={styles.getStartedText}> Every kind donation is appreciated! </Text>
          </View>
          {this.scanrQRcode()}
          <Image style={{width: 250, height: 250, alignSelf: 'center', marginTop: 30}}
          source={require('../assets/images/logo.png')}/>
          <Text style={styles.textC}> Start by scannying the QR code of the person you want to help </Text>
          <TouchableOpacity style={styles.button} onPress={this._handlePressUrl} title="Scan QR code">
            <Text>Scan QR code</Text>
          </TouchableOpacity>
        </ScrollView>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  textC: {
    fontSize: 17,
    marginTop: 30,
    marginLeft: 5,
    color: 'rgba(96,100,109, 1)',
    lineHeight: 24,
    textAlign: 'center',
  },
  button: {
    alignSelf: 'center',
    backgroundColor: '#c9efe6',
    marginTop: 60,
    textAlign: 'center',
    width: 200,
    height: 50,
    alignItems: 'center',
    justifyContent: 'center',
    borderBottomLeftRadius: 8,
    borderBottomRightRadius: 8,
    borderTopLeftRadius: 8,
    borderTopRightRadius: 8,
    alignSelf: "center"
  },
  bar: {
    backgroundColor: 'rgb(6, 18, 20)',
    height: 1,
    marginTop: 5
  },
  container: {
    flex: 1,
    backgroundColor: '#f9fffd',
  },
  contentContainer: {
    paddingTop: 30,
  },
  welcomeContainer: {
    alignItems: 'center',
    marginTop: 10,
    marginBottom: 20,
  },
  welcomeImage: {
    width: 100,
    height: 80,
    resizeMode: 'contain',
    marginTop: 3,
    marginLeft: -10,
  },
  getStartedContainer: {
    alignItems: 'center',
    marginHorizontal: 50,
  },
  homeScreenFilename: {
    marginVertical: 7,
  },
  codeHighlightText: {
    color: 'rgba(96,100,109, 0.8)',
  },
  codeHighlightContainer: {
    backgroundColor: 'rgba(0,0,0,0.05)',
    borderRadius: 3,
    paddingHorizontal: 4,
  },
  getStartedText: {
    fontSize: 20,
    color: 'rgba(96,100,109, 1)',
    lineHeight: 24,
    textAlign: 'center',
  },
  tabBarInfoContainer: {
    position: 'absolute',
    bottom: 0,
    left: 0,
    right: 0,
    ...Platform.select({
      ios: {
        shadowColor: 'black',
        shadowOffset: { height: -3 },
        shadowOpacity: 0.1,
        shadowRadius: 3,
      },
      android: {
        elevation: 20,
      },
    }),
    alignItems: 'center',
    backgroundColor: '#fbfbfb',
    paddingVertical: 20,
  },
  tabBarInfoText: {
    fontSize: 17,
    color: 'rgba(96,100,109, 1)',
    textAlign: 'center',
  }
});
