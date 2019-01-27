import React from 'react';
import { Alert, View, ScrollView, StyleSheet, Text, TouchableOpacity, TextInput, TouchableHighlightBase } from 'react-native';
import { ProfileCard } from '../components/ProfileCard';


export default class DonationScreen extends React.Component {
    state = {
        amount: "5"
    }

    static navigationOptions = {
        title: 'Profile',
    };

    _sendMoney = () => {
        const { navigate } = this.props.navigation;
        const parameters = this.props.navigation.state.params;
        console.log(parameters);
        Alert.alert(
            'Money were sent',
            'Thank you for your kind gesture!',
            [
                { text: 'OK', onPress: () => navigate('Front', {}) }
            ],
            { cancelable: false },
        )
        fetch('https://homelesshelper.herokuapp.com/sendDonation/', {
            method: 'POST',
            headers: {
                //Accept: 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                amount: parseInt(this.state.amount),
                receiver_id: parameters.id,
                donator_id: 6,
            }),
        })
            .then(() => {
                Alert.alert(
                    'Money were sent',
                    'Thank you for your kind gesture!',
                    [
                        { text: 'OK', onPress: () => navigate('Front', {}) }
                    ],
                    { cancelable: true },
                )
            })
            .catch((error) => {
                console.error(error);
            });
    }

    render() {
        const parameters = this.props.navigation.state.params;
        return (
            <ScrollView style={styles.container}>
                <ProfileCard name={parameters.name} info={parameters.info} balance={parameters.balance} />
                <View>
                    <View style={styles.moneyContainer}>
                        <TouchableOpacity style={styles.minusButton} onPress={this._substract}>
                            <Text style={styles.text}> - </Text>
                        </TouchableOpacity>
                        <TextInput style={styles.input} underlineColorAndroid="transparent"
                            placeholder={this.state.amount}
                            fontSize='26'
                            placeholderTextColor="grey"
                            numberOfLines={1}
                            value={this.state.amount}
                            onChange={(text) => this.setState({ amount: text })}
                        >
                        </TextInput>
                        <TouchableOpacity style={styles.plusButton} onPress={this._add}>
                            <Text style={styles.text}> + </Text>
                        </TouchableOpacity>
                    </View>
                </View>
                <TouchableOpacity style={styles.button} onPress={this._sendMoney}>
                    <Text style={styles.text}> Donate </Text>
                </TouchableOpacity>
            </ScrollView>
        );
    }


    _substract = () => {
        previousAmount = "" + (parseFloat(this.state.amount) - 1)
        this.setState({ amount: previousAmount })
    }

    _add = () => {
        previousAmount = "" + (parseFloat(this.state.amount) + 1)
        this.setState({ amount: previousAmount })
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
    input: {
        textAlign: 'center',
        borderBottomWidth: 2,
        width: 120,
        height: 30,
        borderBottomColor: '#c9efe6',
        marginLeft: 5,
        marginRight: 5
    },
    moneyContainer: {
        flexDirection: 'row', flexWrap: 'wrap',
        marginTop: 100,
        alignSelf: 'center'
    },
    text: {
        fontSize: 27,
        alignSelf: 'center'
    },
    minusButton: {
        justifyContent: 'center',
        alignContent: 'center',
        marginLeft: 40,
        backgroundColor: '#c9efe6',
        borderBottomLeftRadius: 24,
        borderBottomRightRadius: 24,
        borderTopLeftRadius: 24,
        borderTopRightRadius: 24,
        width: 45,
        height: 45,
    },
    plusButton: {
        justifyContent: 'center',
        alignContent: 'center',
        marginRight: 40,
        backgroundColor: '#c9efe6',
        borderBottomLeftRadius: 24,
        borderBottomRightRadius: 24,
        borderTopLeftRadius: 24,
        borderTopRightRadius: 24,
        width: 45,
        height: 45,
    },

});

