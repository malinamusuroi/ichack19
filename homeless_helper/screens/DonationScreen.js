import React from 'react';
import { Alert, View, ScrollView, StyleSheet, Text, TouchableOpacity, TextInput, TouchableHighlightBase } from 'react-native';
import { ProfileCard } from '../components/ProfileCard';
import { NumericInput } from '../components/NumericInput';


export default class DonationScreen extends React.Component {

  static navigationOptions = {
    title: 'Profile',
  };

  _sendMoney = () => {
    Alert.alert(
      'Money were sent',
      'Thank you for your kind gesture!',
      [
        {text: 'OK', onPress: () => console.log('OK Pressed')},
      ],
      {cancelable: false},
      )

    

  }

  render() {
    const parameters = this.props.navigation.state.params;
    console.log("Navigation Props");
    return (
      <ScrollView style={styles.container}>
        <ProfileCard name={parameters.name} info={parameters.info} balance={parameters.balance}/>
        <View>
          <NumericInput />
        </View>
        <TouchableOpacity style={styles.button} onPress={this._sendMoney}>
          <Text style={styles.text}> Donate money </Text>
        </TouchableOpacity>
      </ScrollView>
    );
  }
}


const styles = StyleSheet.create({
  button: {
    backgroundColor: '#c9efe6',
    width: 230,
    height: 40,
    marginTop: 45,
    alignSelf: 'center',
    borderBottomLeftRadius: 8,
    borderBottomRightRadius: 8,
    borderTopLeftRadius: 8,
    borderTopRightRadius: 8,
    justifyContent: 'center',
    alignItems: 'center'
  },
  text: {
    fontSize: 17
  },
  container: {
    flex: 1,
    paddingTop: 15,
    backgroundColor: '#f9fffd',
  },
});

